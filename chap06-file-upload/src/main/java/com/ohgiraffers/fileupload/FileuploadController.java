package com.ohgiraffers.fileupload;

import jakarta.annotation.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileuploadController {

    @Resource
    private ResourceLoader resourceLoader;

    @RequestMapping(value = {"/","/main"})
    public String index(){
        return "main";
    }

    @PostMapping("single-file")
    public String singleFileUpload(@RequestParam MultipartFile singleFile, String singleFileDescription , Model model) throws IOException {
        System.out.println("single file : "+ singleFile);
        System.out.println("원본 파일 이름: " + singleFile.getOriginalFilename()); //* 주석 3개 중요
        System.out.println("input name: " + singleFile.getName());
//        System.out.println("원본 파일 객체: " + singleFile.getBytes()); // 데이터 0101  -[B@2740ba4b 이건 주소값 // 객체를 보낸다
        System.out.println("원본 파일 사이즈: " + singleFile.getSize()); // 용량

        //파일을 저장할 경로 설정
//        String root = "/Users/baekjonghwan/upload-files";
//        String filePath = root + "/single";
        String filePath = resourceLoader.getResource("classpath:static/img/").getFile().getAbsolutePath();

        File dir = new File(filePath);

        if (!dir.exists()){
            dir.mkdirs();
        }

        //이름이 중복되지 않게 사용하는 방법. UUID.randomUUID 는 중복되지 않게 랜덤 이름 준다.
        String originFileName = singleFile.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String savedName = UUID.randomUUID().toString().replace("-","")+ext;

        try {
            System.out.println("filePath ============" + filePath);
            singleFile.transferTo(new File(filePath + "/" + savedName));
            model.addAttribute("message", "파일 업로드 성공");
            model.addAttribute("img","static/img/"+savedName);
        }catch (IOException e){
            e.printStackTrace();
            model.addAttribute("message", "파일 업로드 실패");
        }

        return "result";
    }

    @PostMapping("multi-file")
    public String multiFileUpload(@RequestParam List<MultipartFile> multipartFiles,
                                  String multiFileDescription, Model model){
        System.out.println("multiFiles : " + multipartFiles);
        System.out.println("multiFIleDescription :" +multiFileDescription);

        String root = "/Users/baekjonghwan/upload-files";
        String filePath =  root+"/multi1";

        File dir = new File(filePath);
        if (!dir.exists()){
            dir.mkdirs();
        }

        List<FileDTO> files = new ArrayList<>();
        try {
            for (MultipartFile file : multipartFiles) {
                String originFileName = file.getOriginalFilename();
                String ext = originFileName.substring(originFileName.lastIndexOf("."));
                String savedName = UUID.randomUUID().toString().replace("-", "") + ext;
                files.add(new FileDTO(originFileName, savedName, filePath, multiFileDescription));
                file.transferTo(new File(filePath, "/" + savedName));
            }
            model.addAttribute("message", "다중 파일 업로드 성공");
        } catch(IOException e){
                e.printStackTrace();

                for (FileDTO file : files){
                    new File(filePath + "/" + file.getSavedName()).delete();
            }
                model.addAttribute("message", "다중 파일 업로드 실패");
        }
        return "result";
    }

}

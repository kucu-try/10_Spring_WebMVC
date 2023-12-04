package com.ohgiraffers.request;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller     //사용자의 요청을 받아주는 서블릿
//@RestController  //화면 필요없이 데이터만 보내줌
@RequestMapping("/order/*") //order 하위 모두 처리
public class ClassMappingTextController {
    // port : 80 = web
    // port :8080 = was
    // port : 443 = https

    //Get :  localhost: 8080/order/regist  이요청이 들어오면 맵핑해줌
    @GetMapping("/regist")
    public String registOrder(Model model){
        model.addAttribute("message", "get 방식의 주문 등록을 핸들러 메소드 호출");

        return "mappingResult";
    }

    @RequestMapping(value = {"modify","delete"} , method = RequestMethod.POST)
    public String modifyAndDelete(Model model){

        model.addAttribute("message","post 방식의 주문 정보 수정과 주문 정보 삭제 공통 처리용 핸들러");
        return "mappingResult";
    }

    /*
    * 3. path Variable
    * @PathVariable 어노테이션을 이용해 요청을 path 로 부터 변수를 받아올 수 있다.
    * path variable 로 전달되는 {변수명} 값은 반드시 매개 변수명과 동일해야한다.
    * 만약 동일하지 않으면@pathVariable("이름")을 설정해주어야한다.
    * 이는 rest 형 웹 서비스를 설계할때 유용하게 사용된ㄷㅏ,
    *
    * 인텔리제이의 builder설정을 인텔리제이로 했을 경우에는 @PathVariable에 이름을 지정해 주지 않으면 찾지 못한다,
    * */
    @GetMapping("/detail/{orderNo}")
    public String selectOrderDetail(Model model, @PathVariable("orderNo") int orderNo){
        model.addAttribute("message",orderNo + "번 주문 상세 내용 조회용 핸들러 메소드 호출");
        return "mappingResult";
    }

    @RequestMapping
    public String otherRequest(Model model){

        model.addAttribute("message","order 요청이긴 하지만 다른 기능이 준비되지 않음");
        return "mappingResult";
    }
}

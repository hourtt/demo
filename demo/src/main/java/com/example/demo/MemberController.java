package com.example.demo;

import com.example.demo.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }


// static folder doesn't need route for view their page
    // if you want to view their page , just type http://localhost:8080/file_name.html

//    //This is called handler method
//    @GetMapping("/template-page")
//    //The name of handler method must be the same as the html file in templates folder
//    public String template_index() {
//        return "template_index";
//    }
//public  MemberController(MemberService memberService) {
//    this.memberService = memberService;
//}

    @GetMapping("/members/new")
    public String createForm(){
        // redirect to the folder
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm memberForm){
        Member member = new Member();
        member.setName(memberForm.getName());
       memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }

// I've added this new Mapping route for testing
    @PostMapping("/form")
    public String create(Member form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "memberAddForm";
    }


}

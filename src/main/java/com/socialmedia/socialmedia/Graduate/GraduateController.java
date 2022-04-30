package com.socialmedia.socialmedia.Graduate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GraduateController {

    @Autowired
    private GraduateDAOImpl graduateDAO;

    @PostMapping("/graduate")
    public Graduate createGraduate(@RequestBody GraduateDTO graduateDTO){
       Graduate graduate = new Graduate();
       graduate.setName(graduateDTO.getName());

       Passport passport = new Passport();
       passport.setPassportNo(graduateDTO.getPassportNo());
       graduate = graduateDAO.save(graduate, passport);
       return graduate;
    }

    @GetMapping("/graduate/{id}")
    public Graduate findById(@PathVariable("id") int id){
        Graduate graduate = graduateDAO.findById(id);
        return graduate;
    }

    @GetMapping("/graduate")
    public List<Graduate> find(){
        List<Graduate> graduates = graduateDAO.find();
        return graduates;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/passport/{pid}")
    public Passport getPassport(@PathVariable int pid){
        Passport passport = graduateDAO.findpassById(pid);
        return passport;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xavier.xavierblogcms.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xavier.xavierblogcms.models.Admin;
import xavier.xavierblogcms.repository.AdminRepository;

/**
 *
 * @author Saviour Umoeka
 */@Service
public class CustomAdminDetailsService implements UserDetailsService {

        @Autowired
    private AdminRepository adminRepo;
        
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Admin admin = adminRepo.findByUserName(username);
         CustomAdminDetails userDetails = null;
         
          if(admin != null)
         {
             userDetails = new CustomAdminDetails();
             userDetails.setAdmin(admin);
         }
         else
             throw new UsernameNotFoundException("Admin with Usernamw add "+ username +" does not exist");
         
         return userDetails;
    }
    
}

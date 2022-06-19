package pl.medicaap.tomaszwisniowski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.medicaap.tomaszwisniowski.model.NewUserDetails;
import pl.medicaap.tomaszwisniowski.model.User;
import pl.medicaap.tomaszwisniowski.repository.UserRepository;

import java.util.Optional;


@Service
public class NewUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        System.out.println(user + " TO JEST MIEJSCE TESTU");

        user.orElseThrow(() -> new UsernameNotFoundException("Nie znaleziono użytkownika :" + userName));

        return user.map(NewUserDetails::new).get();

    }
}
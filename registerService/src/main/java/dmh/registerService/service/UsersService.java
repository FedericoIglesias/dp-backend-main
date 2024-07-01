package dmh.registerService.service;

import dmh.registerService.model.Users;
import dmh.registerService.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService implements UserDetailsService, IUsersService{

    @Autowired
    IUsersRepository repoUser;

    @Override
    public List<Users> getListUsers() {
        return repoUser.findAll();
    }

    @Override
    public Users getUser(Integer id) {
        return repoUser.findById(id).orElse(null);
    }

    @Override
    public void saveUser(Users user) {
    repoUser.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
    repoUser.deleteById(id);
    }

    @Override
    public Users modifyUser(Users user) {
        repoUser.save(user);
        return repoUser.findById(user.getId()).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = repoUser.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return (UserDetails) new Users(user.getName(), user.getPassword());
    }
    }

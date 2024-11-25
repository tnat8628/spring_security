package vn.iotstar.configs;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import vn.iotstar.entity.UserInfo;
import vn.iotstar.repository.UsereInfoRepository;

public class UserInfoService implements UserDetailsService{

	@Autowired
	UsereInfoRepository repository;
	
	public UserInfoService(UsereInfoRepository userInfoRepository) {
		this.repository = userInfoRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo = repository.findByName(username);
		return userInfo.map(UserInfoUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
	}

}

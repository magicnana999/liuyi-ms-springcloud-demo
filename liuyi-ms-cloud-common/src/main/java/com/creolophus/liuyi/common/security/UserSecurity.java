package com.creolophus.liuyi.common.security;

import com.creolophus.liuyi.common.entity.User;
import org.apache.commons.lang3.StringUtils;

/**
 * @author magicnana
 * @date 2019/7/2 上午12:11
 */
public class UserSecurity {

    private Long userId;
    private String token;
    private Long timestamp;
    private String title = Role.USER.name();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public enum Role {
        PROFESSOR("ROLE_PROFESSOR"),
        MANAGER("ROLE_MANAGER"),
        USER("ROLE_USER"),
        ;

        private String role;

        public String getRole() {
            return role;
        }

        Role(String role) {
            this.role = role;
        }

//        public static Role valueOf(String title){
//            if(StringUtils.isBlank(title)){
//                return null;
//            }
//            return null;
//        }
    }

    public UserSecurity(){}

    public UserSecurity(User user, String token){
        this.userId = user.getId();
        this.timestamp = System.currentTimeMillis();
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    //    @JSONField(serialize = false)
//    public UserDetails transfer(){
//
//        return new UserDetails() {
//            @Override
//            public Collection<? extends GrantedAuthority> getAuthorities() {
//                if(type != null && type == 1) {
//                    return Arrays.asList(new SimpleGrantedAuthority("ROLE_VIP"));
//                }
//                return Collections.emptyList();            }
//
//            @Override
//            public String getPassword() {
//                return "";
//            }
//
//            @Override
//            public String getUsername() {
//                return userId+"";
//            }
//
//            @Override
//            public boolean isAccountNonExpired() {
//                return true;
//            }
//
//            @Override
//            public boolean isAccountNonLocked() {
//                return true;
//            }
//
//            @Override
//            public boolean isCredentialsNonExpired() {
//                return true;
//            }
//
//            @Override
//            public boolean isEnabled() {
//                return true;
//            }
//        };
//    }


}

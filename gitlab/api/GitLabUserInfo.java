package com.yanqiancloud.control.configserver.login.gitlab.api;

import java.util.List;

/**
 * @ProjectName: yqcloud
 * @Description: gitlab用户基本信息
 * @Author: lingyun.wei
 * @CreateDate: 2018/10/18 15:11
 * @Version: 1.0
 */
public class GitLabUserInfo {

    private String id;

    private String username;

    private String email;

    private String name;

    private String state;

    private String avatar_url;

    private String web_url;

    private String created_at;

    private Boolean is_admin;

    private String bio;

    private String location;

    private String skype;

    private String linkedin;

    private String twitter;

    private String website_url;

    private String organization;

    private String last_sign_in_at;

    private String confirmed_at;

    private Long theme_id;

    private String last_activity_on;

    private Long color_scheme_id;

    private Long projects_limit;

    private String current_sign_in_at;

    private List<Identity> identities;

    private Boolean can_create_group;

    private Boolean can_create_project;

    private Boolean two_factor_enabled;

    private Boolean external;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getLast_sign_in_at() {
        return last_sign_in_at;
    }

    public void setLast_sign_in_at(String last_sign_in_at) {
        this.last_sign_in_at = last_sign_in_at;
    }

    public String getConfirmed_at() {
        return confirmed_at;
    }

    public void setConfirmed_at(String confirmed_at) {
        this.confirmed_at = confirmed_at;
    }

    public Long getTheme_id() {
        return theme_id;
    }

    public void setTheme_id(Long theme_id) {
        this.theme_id = theme_id;
    }

    public String getLast_activity_on() {
        return last_activity_on;
    }

    public void setLast_activity_on(String last_activity_on) {
        this.last_activity_on = last_activity_on;
    }

    public Long getColor_scheme_id() {
        return color_scheme_id;
    }

    public void setColor_scheme_id(Long color_scheme_id) {
        this.color_scheme_id = color_scheme_id;
    }

    public Long getProjects_limit() {
        return projects_limit;
    }

    public void setProjects_limit(Long projects_limit) {
        this.projects_limit = projects_limit;
    }

    public String getCurrent_sign_in_at() {
        return current_sign_in_at;
    }

    public void setCurrent_sign_in_at(String current_sign_in_at) {
        this.current_sign_in_at = current_sign_in_at;
    }

    public List<Identity> getIdentities() {
        return identities;
    }

    public void setIdentities(List<Identity> identities) {
        this.identities = identities;
    }

    public Boolean getCan_create_group() {
        return can_create_group;
    }

    public void setCan_create_group(Boolean can_create_group) {
        this.can_create_group = can_create_group;
    }

    public Boolean getCan_create_project() {
        return can_create_project;
    }

    public void setCan_create_project(Boolean can_create_project) {
        this.can_create_project = can_create_project;
    }

    public Boolean getTwo_factor_enabled() {
        return two_factor_enabled;
    }

    public void setTwo_factor_enabled(Boolean two_factor_enabled) {
        this.two_factor_enabled = two_factor_enabled;
    }

    public Boolean getExternal() {
        return external;
    }

    public void setExternal(Boolean external) {
        this.external = external;
    }
}

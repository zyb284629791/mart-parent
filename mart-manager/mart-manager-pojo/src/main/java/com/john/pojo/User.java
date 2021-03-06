package com.john.pojo;

import java.io.Serializable;

public class User implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sec_user.id
     *
     * @mbg.generated Tue Jun 26 16:30:47 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sec_user.name
     *
     * @mbg.generated Tue Jun 26 16:30:47 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sec_user.age
     *
     * @mbg.generated Tue Jun 26 16:30:47 CST 2018
     */
    private Integer age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sec_user.note
     *
     * @mbg.generated Tue Jun 26 16:30:47 CST 2018
     */
    private String note;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sec_user.id
     *
     * @return the value of t_sec_user.id
     *
     * @mbg.generated Tue Jun 26 16:30:47 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sec_user.id
     *
     * @param id the value for t_sec_user.id
     *
     * @mbg.generated Tue Jun 26 16:30:47 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sec_user.name
     *
     * @return the value of t_sec_user.name
     *
     * @mbg.generated Tue Jun 26 16:30:47 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sec_user.name
     *
     * @param name the value for t_sec_user.name
     *
     * @mbg.generated Tue Jun 26 16:30:47 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sec_user.age
     *
     * @return the value of t_sec_user.age
     *
     * @mbg.generated Tue Jun 26 16:30:47 CST 2018
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sec_user.age
     *
     * @param age the value for t_sec_user.age
     *
     * @mbg.generated Tue Jun 26 16:30:47 CST 2018
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sec_user.note
     *
     * @return the value of t_sec_user.note
     *
     * @mbg.generated Tue Jun 26 16:30:47 CST 2018
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sec_user.note
     *
     * @param note the value for t_sec_user.note
     *
     * @mbg.generated Tue Jun 26 16:30:47 CST 2018
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}
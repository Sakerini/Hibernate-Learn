package com.sakerini.eagervslazy.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="youtube_channel")
    private String youtubeChannel;

    @Column(name="hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail",
            cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST,
                    CascadeType.REFRESH})

    private Instructor instructor;

    public InstructorDetail() {

    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail[id= " + id + ", youchannel= " + youtubeChannel + ", hobby= " + hobby + " ]";
    }

}

package org.example.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "hobby")
@Getter
@Setter
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String wikilink;

    @Column(length = 50, nullable = false)
    private String category;

    @Column(length = 50, nullable = false)
    private String type;

    @ManyToMany(mappedBy = "hobbies")
    private List<UserInfo> userInfos;
}


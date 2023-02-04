package com.example.ibooks.dto.responses.author;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class AllAuthorsList implements Serializable {
    private int id;
    private String fullname;
    private String birthday;
    private String info;

    public AllAuthorsList(int id, String fullname, String birthday, String info) {
        this.id = id;
        this.fullname = fullname;
        this.birthday = birthday;
        this.info = info;
    }
}

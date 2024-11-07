package com.example.spring_boot_sample.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/*
localhost:55432/first_database
*/
/*
CREATE TABLE public.first_table (
    first_table_idx int8 GENERATED ALWAYS AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
    column_name varchar(30) NOT NULL,
    nick_name varchar(50) NOT NULL,
    CONSTRAINT "first_table_nick_name_key" UNIQUE (nick_name),
    CONSTRAINT "first_table_pkey" PRIMARY KEY (first_table_idx)
);
*/

@ToString
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "first_table")
public class Db1Entity {

    @Id
    @Column("first_table_idx")
    private Long firstTableIdx;

    @Column("column_name")
    private String columnName;

    @Column("nick_name")
    private String nickName;

}

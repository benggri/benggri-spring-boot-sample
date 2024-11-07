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
localhost:55432/second_database
*/
/*
CREATE TABLE public.second_table (
    second_table_idx int8 GENERATED ALWAYS AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
    column_name varchar(30) NOT NULL,
    create_first_table_idx int8 NOT NULL,
    CONSTRAINT "second_table_pkey" PRIMARY KEY (second_table_idx)
);
*/

@ToString
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "second_table")
public class Db2Entity {

    @Id
    @Column("second_table_idx")
    private Long secondTableIdx;

    @Column("column_name")
    private String columnName;

    // The value of this column is first_table_idx
    // database: first_database, table: first_table
    // java: Db1Entity.firstTableIdx
    @Column("create_first_table_idx")
    private Long createFirstTableIdx;

}

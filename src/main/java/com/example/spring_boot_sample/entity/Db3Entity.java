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
localhost:55432/third_database
*/
/*
CREATE TABLE public.third_table (
    third_table_idx int8 GENERATED ALWAYS AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
    column_name varchar(30) NOT NULL,
    create_first_table_idx int8 NOT NULL,
    CONSTRAINT "third_table_pkey" PRIMARY KEY (third_table_idx)
);
*/

@ToString
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "third_table")
public class Db3Entity {

    @Id
    @Column("third_table_idx")
    private Long thirdTableIdx;

    @Column("column_name")
    private String columnName;

    // The value of this column is first_table_idx
    // database: first_database, table: first_table
    // java: Db1Entity.firstTableIdx
    @Column("create_first_table_idx")
    private Long createFirstTableIdx;

}

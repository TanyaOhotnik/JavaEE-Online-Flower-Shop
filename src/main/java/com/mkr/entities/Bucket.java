package com.mkr.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Tanya Ohotnik on 09.11.2016.
 */
@Entity
@Table(name = "bucket")
public class Bucket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bucket_id")
    private int id;
}

package com.maple.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMainBenner is a Querydsl query type for MainBenner
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMainBenner extends EntityPathBase<MainBenner> {

    private static final long serialVersionUID = -1638083665L;

    public static final QMainBenner mainBenner = new QMainBenner("mainBenner");

    public final com.maple.admin.util.QDateEntityUtil _super = new com.maple.admin.util.QDateEntityUtil(this);

    public final StringPath banner_restype = createString("banner_restype");

    public final StringPath benner_endate = createString("benner_endate");

    public final StringPath benner_image = createString("benner_image");

    public final NumberPath<Integer> benner_seq = createNumber("benner_seq", Integer.class);

    public final StringPath benner_stardate = createString("benner_stardate");

    public final StringPath benner_title = createString("benner_title");

    public final StringPath benner_type = createString("benner_type");

    //inherited
    public final DateTimePath<java.time.Instant> createDate = _super.createDate;

    //inherited
    public final DateTimePath<java.time.Instant> updateDate = _super.updateDate;

    public QMainBenner(String variable) {
        super(MainBenner.class, forVariable(variable));
    }

    public QMainBenner(Path<? extends MainBenner> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMainBenner(PathMetadata metadata) {
        super(MainBenner.class, metadata);
    }

}


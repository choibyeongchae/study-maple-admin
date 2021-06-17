package com.maple.admin.util;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDateEntityUtil is a Querydsl query type for DateEntityUtil
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QDateEntityUtil extends EntityPathBase<DateEntityUtil> {

    private static final long serialVersionUID = -1697298950L;

    public static final QDateEntityUtil dateEntityUtil = new QDateEntityUtil("dateEntityUtil");

    public final DateTimePath<java.time.Instant> createDate = createDateTime("createDate", java.time.Instant.class);

    public final DateTimePath<java.time.Instant> updateDate = createDateTime("updateDate", java.time.Instant.class);

    public QDateEntityUtil(String variable) {
        super(DateEntityUtil.class, forVariable(variable));
    }

    public QDateEntityUtil(Path<? extends DateEntityUtil> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDateEntityUtil(PathMetadata metadata) {
        super(DateEntityUtil.class, metadata);
    }

}


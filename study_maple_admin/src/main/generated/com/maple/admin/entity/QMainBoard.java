package com.maple.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMainBoard is a Querydsl query type for MainBoard
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMainBoard extends EntityPathBase<MainBoard> {

    private static final long serialVersionUID = -883839865L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMainBoard mainBoard = new QMainBoard("mainBoard");

    public final com.maple.admin.util.QDateEntityUtil _super = new com.maple.admin.util.QDateEntityUtil(this);

    public final StringPath boader_contents = createString("boader_contents");

    public final NumberPath<Integer> boader_seq = createNumber("boader_seq", Integer.class);

    public final StringPath boader_title = createString("boader_title");

    public final DatePath<java.sql.Date> boader_type = createDate("boader_type", java.sql.Date.class);

    public final StringPath boader_viewcnt = createString("boader_viewcnt");

    //inherited
    public final DateTimePath<java.time.Instant> createDate = _super.createDate;

    public final StringPath mbr_email = createString("mbr_email");

    public final NumberPath<Integer> mbr_no = createNumber("mbr_no", Integer.class);

    public final QMember member;

    //inherited
    public final DateTimePath<java.time.Instant> updateDate = _super.updateDate;

    public QMainBoard(String variable) {
        this(MainBoard.class, forVariable(variable), INITS);
    }

    public QMainBoard(Path<? extends MainBoard> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMainBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMainBoard(PathMetadata metadata, PathInits inits) {
        this(MainBoard.class, metadata, inits);
    }

    public QMainBoard(Class<? extends MainBoard> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}


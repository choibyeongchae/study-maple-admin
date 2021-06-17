package com.maple.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardComents is a Querydsl query type for BoardComents
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoardComents extends EntityPathBase<BoardComents> {

    private static final long serialVersionUID = -1072211447L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardComents boardComents = new QBoardComents("boardComents");

    public final com.maple.admin.util.QDateEntityUtil _super = new com.maple.admin.util.QDateEntityUtil(this);

    public final NumberPath<Integer> boader_seq = createNumber("boader_seq", Integer.class);

    public final StringPath com_contents = createString("com_contents");

    public final NumberPath<Integer> coment_seq = createNumber("coment_seq", Integer.class);

    //inherited
    public final DateTimePath<java.time.Instant> createDate = _super.createDate;

    public final QMainBoard mainBoard;

    public final StringPath mbr_email = createString("mbr_email");

    public final NumberPath<Integer> mbr_no = createNumber("mbr_no", Integer.class);

    //inherited
    public final DateTimePath<java.time.Instant> updateDate = _super.updateDate;

    public QBoardComents(String variable) {
        this(BoardComents.class, forVariable(variable), INITS);
    }

    public QBoardComents(Path<? extends BoardComents> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardComents(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardComents(PathMetadata metadata, PathInits inits) {
        this(BoardComents.class, metadata, inits);
    }

    public QBoardComents(Class<? extends BoardComents> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mainBoard = inits.isInitialized("mainBoard") ? new QMainBoard(forProperty("mainBoard"), inits.get("mainBoard")) : null;
    }

}


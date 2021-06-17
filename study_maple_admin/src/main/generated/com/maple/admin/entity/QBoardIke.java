package com.maple.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardIke is a Querydsl query type for BoardIke
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoardIke extends EntityPathBase<BoardIke> {

    private static final long serialVersionUID = 1175557027L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardIke boardIke = new QBoardIke("boardIke");

    public final com.maple.admin.util.QDateEntityUtil _super = new com.maple.admin.util.QDateEntityUtil(this);

    public final NumberPath<Integer> boader_seq = createNumber("boader_seq", Integer.class);

    //inherited
    public final DateTimePath<java.time.Instant> createDate = _super.createDate;

    public final NumberPath<Integer> history_seq = createNumber("history_seq", Integer.class);

    public final QMainBoard mainBoard;

    public final StringPath mbr_email = createString("mbr_email");

    public final NumberPath<Integer> mbr_no = createNumber("mbr_no", Integer.class);

    //inherited
    public final DateTimePath<java.time.Instant> updateDate = _super.updateDate;

    public QBoardIke(String variable) {
        this(BoardIke.class, forVariable(variable), INITS);
    }

    public QBoardIke(Path<? extends BoardIke> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardIke(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardIke(PathMetadata metadata, PathInits inits) {
        this(BoardIke.class, metadata, inits);
    }

    public QBoardIke(Class<? extends BoardIke> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mainBoard = inits.isInitialized("mainBoard") ? new QMainBoard(forProperty("mainBoard"), inits.get("mainBoard")) : null;
    }

}


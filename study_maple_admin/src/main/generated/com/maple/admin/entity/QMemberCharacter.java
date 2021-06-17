package com.maple.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberCharacter is a Querydsl query type for MemberCharacter
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMemberCharacter extends EntityPathBase<MemberCharacter> {

    private static final long serialVersionUID = -1213933047L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberCharacter memberCharacter = new QMemberCharacter("memberCharacter");

    public final com.maple.admin.util.QDateEntityUtil _super = new com.maple.admin.util.QDateEntityUtil(this);

    public final StringPath caharacter_name = createString("caharacter_name");

    public final StringPath cha_job = createString("cha_job");

    public final NumberPath<Integer> cha_level = createNumber("cha_level", Integer.class);

    public final StringPath cha_server = createString("cha_server");

    //inherited
    public final DateTimePath<java.time.Instant> createDate = _super.createDate;

    public final StringPath mbr_email = createString("mbr_email");

    public final NumberPath<Integer> mbr_no = createNumber("mbr_no", Integer.class);

    public final QMember member;

    //inherited
    public final DateTimePath<java.time.Instant> updateDate = _super.updateDate;

    public QMemberCharacter(String variable) {
        this(MemberCharacter.class, forVariable(variable), INITS);
    }

    public QMemberCharacter(Path<? extends MemberCharacter> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberCharacter(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberCharacter(PathMetadata metadata, PathInits inits) {
        this(MemberCharacter.class, metadata, inits);
    }

    public QMemberCharacter(Class<? extends MemberCharacter> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}


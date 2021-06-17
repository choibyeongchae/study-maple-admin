package com.maple.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QItemMaster is a Querydsl query type for ItemMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItemMaster extends EntityPathBase<ItemMaster> {

    private static final long serialVersionUID = 208644795L;

    public static final QItemMaster itemMaster = new QItemMaster("itemMaster");

    public final com.maple.admin.util.QDateEntityUtil _super = new com.maple.admin.util.QDateEntityUtil(this);

    //inherited
    public final DateTimePath<java.time.Instant> createDate = _super.createDate;

    public final StringPath item_attack = createString("item_attack");

    public final StringPath item_desc = createString("item_desc");

    public final StringPath item_dex = createString("item_dex");

    public final StringPath item_ficat = createString("item_ficat");

    public final StringPath item_int = createString("item_int");

    public final StringPath item_job = createString("item_job");

    public final StringPath item_luk = createString("item_luk");

    public final StringPath item_mattack = createString("item_mattack");

    public final StringPath item_name = createString("item_name");

    public final NumberPath<Integer> item_seq = createNumber("item_seq", Integer.class);

    public final StringPath item_str = createString("item_str");

    public final StringPath item_strapos = createString("item_strapos");

    public final StringPath item_takelevel = createString("item_takelevel");

    public final StringPath item_type = createString("item_type");

    public final StringPath item_upgarde = createString("item_upgarde");

    //inherited
    public final DateTimePath<java.time.Instant> updateDate = _super.updateDate;

    public QItemMaster(String variable) {
        super(ItemMaster.class, forVariable(variable));
    }

    public QItemMaster(Path<? extends ItemMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItemMaster(PathMetadata metadata) {
        super(ItemMaster.class, metadata);
    }

}


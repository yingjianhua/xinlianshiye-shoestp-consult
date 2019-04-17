package com.xinlianshiye.shoestp.consult.repository.impl;

import java.util.List;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.PathType;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.sql.JPASQLQuery;
import com.querydsl.sql.SQLExpressions;
import com.querydsl.sql.SQLQuery;
import com.xinlianshiye.shoestp.consult.api.entity.Consult;
import com.xinlianshiye.shoestp.consult.api.entity.ConsultRelation;
import com.xinlianshiye.shoestp.consult.api.entity.QConsult;
import com.xinlianshiye.shoestp.consult.api.entity.QConsultRelation;
import com.xinlianshiye.shoestp.consult.repository.AbstractRepository;
import com.xinlianshiye.shoestp.consult.repository.ConsultRepositoryCustom;
import com.xinlianshiye.shoestp.user.api.entity.Purchase;
import com.xinlianshiye.shoestp.user.api.entity.QSupplier;

public class ConsultRepositoryCustomImpl extends AbstractRepository
    implements ConsultRepositoryCustom {

  @Override
  public Integer getLimit(
      Purchase purchase,
      Byte type,
      String keyword,
      Boolean unread,
      Integer lastRelation,
      Integer start,
      Integer limit) {
    QConsult consult = QConsult.consult;
    QConsultRelation consultRelation = QConsultRelation.consultRelation;
    QSupplier supplier = QSupplier.supplier;
    //    JPAQuery<Integer> query =
    //        queryFactory
    //            .select(consultRelation.pkey)
    //            .from(consult)
    //            .from(
    //                Expressions.collectionOperation(Integer.class, PathType.VARIABLE),
    //                Expressions.numberPath(Integer.class, "cc"))
    //            .leftJoin(consultRelation)
    //            .on(consult.pkey.eq(consultRelation.consult));

    //    ExpressionUtils.
    if (lastRelation != null) {
      //      JPAQuery<Integer> query =
      SQLQuery<Integer> query1 =
          SQLExpressions.select(consultRelation.pkey)
              .from(consult)
              .leftJoin(consultRelation)
              .on(consult.pkey.eq(consultRelation.consult));
      if (keyword != null && !keyword.isEmpty()) {
        query1.leftJoin(supplier).on(consultRelation.supplierId.eq(supplier.pkey));
        query1.where(
            consult.title.like("%" + keyword + "%").or(supplier.name.like("%" + keyword + "%")));
      }
      query1.where(consult.purchaseId.eq(purchase.getPkey()));
      query1.where(consult.isDeleted.eq((byte) 0));
      if (type != null) {
        // 询盘类型
        query1.where(consult.type.eq(Consult.Type.values()[type]));
        
        
        
        
             
        
        
        
        
      }

      if (unread != null) { 
        // 是否有新消息
        if (unread) {
          query1.where(
              consultRelation
                  .isNew
                  .eq((byte) 1)
                  .or(consultRelation.readStatus.eq(ConsultRelation.ReadStatus.PURCHASE_UNREAD)));
        }
      }
      query1.groupBy(consult.pkey).orderBy(consult.lastMessageSendTime.desc());
      Integer index =
          createSqlQuery()
              .select(Expressions.numberTemplate(Integer.class, "i"))
              .from(
                  SQLExpressions.select(
                          Expressions.numberTemplate(Integer.class, "( @i \\:= @i + 1 )").as("i"),
                          consultRelation.pkey)
                      .from(query1, consultRelation)
                      .from(Expressions.stringTemplate("(select @i \\:= 0)").as("aa")),
                  consultRelation)
              .where(consultRelation.pkey.eq(lastRelation))
              .fetchOne();
      if (index != null) limit = (index > limit ? index : limit);
    }
    return limit;
  }

  @Override
  public void test() {
    QConsult consult = QConsult.consult;
    QConsultRelation consultRelation = QConsultRelation.consultRelation;
    QSupplier supplier = QSupplier.supplier;
    JPASQLQuery<?> sqlQuery = createSqlQuery();
    sqlQuery
        //        .select(consult.pkey)
        .select(Expressions.numberTemplate(Integer.class, "( @i \\:= @i + 1 )").as("i"))
        .from(consult)
        .from(Expressions.stringTemplate("(select @i \\:= 4)").as("aa"));
    QueryResults<?> fetchResults = sqlQuery.fetchResults();
    List<?> results = fetchResults.getResults();
    System.out.println("---------");
    for (Object object : results) {
      System.out.println(object);
    }
    System.out.println("---------");
  }
}

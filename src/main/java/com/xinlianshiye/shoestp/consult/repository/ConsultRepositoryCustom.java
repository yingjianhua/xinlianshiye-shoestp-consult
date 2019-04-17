package com.xinlianshiye.shoestp.consult.repository;

import com.xinlianshiye.shoestp.user.api.entity.Purchase;

public interface ConsultRepositoryCustom {

  void test();

  Integer getLimit(
      Purchase purchase,
      Byte type,
      String keyword,
      Boolean unread,
      Integer lastRelation,
      Integer start,
      Integer limit);
}

package com.xinlianshiye.shoestp.consult.controller.impl;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xinlianshiye.shoestp.common.api.view.Page;
import com.xinlianshiye.shoestp.consult.api.view.RFQConsultView;
import com.xinlianshiye.shoestp.consult.controller.ConsultController;
import com.xinlianshiye.shoestp.user.api.entity.Purchase;

@RestController
@RequestMapping("/consult")
public class ConsultControllerImpl implements ConsultController {

//  @Autowired private RFQConsultService consultService;

  @Override
  @GetMapping("/pageMine")
  public Page<RFQConsultView> pageMine(
      Purchase purchase,
      Byte t,
      String keyword,
      Boolean unread,
      Integer lastRelation,
      Integer start,
      Integer limit) {
//    return consultService.pageMine(purchase, t, keyword, unread, lastRelation, start, limit);
    return null;
  }

  @Override
  public void unreadCount() throws IOException {
    // TODO Auto-generated method stub

  }

  @Override
  public void detail() throws IOException {
    // TODO Auto-generated method stub

  }

  @Override
  public void edit() throws IOException {
    // TODO Auto-generated method stub

  }

  @Override
  public void addInformation() throws IOException {
    // TODO Auto-generated method stub

  }

  @Override
  public void close() throws IOException {
    // TODO Auto-generated method stub

  }

  @Override
  public void pageMsgs() throws IOException {
    // TODO Auto-generated method stub

  }

  @Override
  public void addImage() throws IOException {
    // TODO Auto-generated method stub

  }

  @Override
  public void addProductRequest() throws IOException {
    // TODO Auto-generated method stub

  }

  @Override
  public void sendMessage() throws IOException {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteQuotation() throws IOException {
    // TODO Auto-generated method stub

  }

  @Override
  public void getRFQList() throws IOException {
    // TODO Auto-generated method stub

  }

  @Override
  public void getRFQDetails() throws IOException {
    // TODO Auto-generated method stub

  }
}

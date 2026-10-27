import 'package:e_store/features/authentication/screens/login/login.dart';
import 'package:flutter/cupertino.dart';
import 'package:get/get.dart';
import 'package:get_storage/get_storage.dart';

class OnBoardingController extends GetxController
{
  static OnBoardingController get instance => Get.find();

  ///Variables
  final pageController = PageController();
  Rx<int> currentPageIndex = 0.obs;
  ///Update Current Index When Page Scroll
  void updatePageIndicator(index) => currentPageIndex = index;

  ///Jump to the Specific dot selescted page
  void dotNavigationClick(index){

    currentPageIndex.value = index;
    pageController.jumpTo(index);
  }

  ///Update Current Index & jump to next page
  void nextPage() {

    if(currentPageIndex.value ==2)
      {
        Get.offAll(const LoginScreen());
      }
    else
      {
        int page= currentPageIndex.value + 1;
        pageController .jumpToPage(page);
      }
  }

  ///update Current Index & jump to the last page
  void skipPage() {
    currentPageIndex.value = 2;
    pageController.jumpToPage(2);
  }
}
import 'package:carousel_slider/carousel_slider.dart';
import 'package:e_store/common/widgets/custom_shapes/containers/circular_container.dart';
import 'package:e_store/common/widgets/products/product_cards/product_card_vertical.dart';
import 'package:e_store/features/shop/screens/home/widgets/promo_slider.dart';
import 'package:e_store/utils/constants/sizes.dart';
import 'package:flutter/material.dart';
import '../../../../../common/widgets/Images/e_rounded_image.dart';
import '../../../../../common/widgets/custom_shapes/containers/primary_header_container.dart';
import '../../../../../common/widgets/custom_shapes/containers/search_container.dart';
import '../../../../../common/widgets/layouts/grid_layout.dart';
import '../../../../../common/widgets/texts/section_heading.dart';
import '../../../../../utils/constants/colors.dart';
import '../../../../../utils/constants/image_strings.dart';
import 'home_appbar.dart';
import 'home_categories.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Column(
          children: [

            const EPrimaryHeaderContainer(
              child: Column(
                children: [
                  ///-----Appbar---
                   EHomeAppBar(),
                   SizedBox(height: ESizes.spaceBtwSections),

                  ///-----Searchbar----
                  ESearchContainer(text: 'Search in Store'),
                  SizedBox(height: ESizes.spaceBtwSections),
                  
                  
                  ///-----Categories---
                  Padding(
                      padding:  EdgeInsets.only(left: ESizes.defaultSpace),
                      child: Column(
                        children: [

                          ///Heading
                           ESectionHeading(title: 'Popular Categories',showActionButton:false,textColor: Colors.white),
                           SizedBox(height: ESizes.spaceBtwItems),

                          ///Categories
                          EHomeCategories()],
                      ),
                  ),
                ],
              ),
            ),

            ///Body--
            Padding(
              padding: const EdgeInsets.all(ESizes.defaultSpace),
              child: Column(
                  children: [
                    ///Promo Slider
                    const EPromoSlider(banners: [EImages.promoBanner1 , EImages.promoBanner2 , EImages.promoBanner3]),
                    SizedBox(height: ESizes.spaceBtwSections),

                    ///popular Products
                    EGridLayout(itemCount: 2,itemBuilder: (_, index) => const EProductCardVertical()),


              ],
            ),

            ),
          ],
        ),
      ),
    );
  }
}

import 'package:e_store/common/styles/shadows.dart';
import 'package:e_store/common/widgets/Images/e_rounded_image.dart';
import 'package:e_store/common/widgets/custom_shapes/containers/rounded_container.dart';
import 'package:e_store/common/widgets/texts/product_price_text.dart';
import 'package:e_store/common/widgets/texts/product_title_text.dart';
import 'package:e_store/utils/constants/colors.dart';
import 'package:e_store/utils/constants/image_strings.dart';
import 'package:e_store/utils/constants/sizes.dart';
import 'package:e_store/utils/helpers/helper_functions.dart';
import 'package:flutter/material.dart';
import 'package:iconsax/iconsax.dart';

import '../../icons/e_circular_icon.dart';

class EProductCardVertical extends StatelessWidget {
  const EProductCardVertical({super.key});

  @override
  Widget build(BuildContext context) {
    final dark = EHelperFunctions.isDarkMode(context);
    ///Container with side paddings, color, edges, radius and shadow
    return GestureDetector(
      onTap: (){},
      child: Container(
          width: 180,
          padding: const EdgeInsets.all(1),
          decoration: BoxDecoration(
            boxShadow: [EShadowStyle.verticalProductShadow],
            borderRadius: BorderRadius.circular(ESizes.productImageRadius),
            color: EHelperFunctions.isDarkMode(context) ? EColors.darkerGrey : EColors.white,
          ),
          child: Column(
            children: [

              ///Thubnail, wishlist,Button, Discount Tag
              ERoundedContainer(
                height: 180,
                padding:  EdgeInsets.all(ESizes.sm),
                backgroundColor: dark ? EColors.dark: EColors.light,
                child: Stack(
                  children: [

                    ///Thumnail Image
                    const ERoundedImage(imageUrl: EImages.productImage1,applyImageRadius: true),

                    ///Sale Tag
                    Positioned(
                      top: 12,
                      child: ERoundedContainer(
                        radius: ESizes.sm,
                        backgroundColor: EColors.Secondary.withOpacity(0.8),
                        padding: const EdgeInsets.symmetric(horizontal: ESizes.sm,vertical: ESizes.xs),
                        child: Text('25%',style: Theme.of(context).textTheme.labelLarge!.apply(color: EColors.black)),
                      ),
                    ),

                    ///Favorite Icon Button
                    Positioned(
                        top: 0,
                        right: 0,
                        child: ECircularIcon(icon: Iconsax.heart5,color: Colors.red),

                    ),
                  ],
                ),
              ),

              const SizedBox(height: ESizes.spaceBtwItems / 2),

              ///Details
              Padding(
                  padding: const EdgeInsets.only(left: ESizes.sm),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      const EProductTitleText(title: 'Green Nike Air Shoes',smallSize: true),
                      const SizedBox(height: ESizes.spaceBtwItems / 2),

                      Row(
                        children: [
                          Text('Nike',overflow: TextOverflow.ellipsis,maxLines: 1,style: Theme.of(context).textTheme.labelMedium),
                          const SizedBox(width: ESizes.xs),
                          const Icon(Iconsax.verify5,color: EColors.primary,size: ESizes.iconXs),
                        ],
                      ),
                      Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          ///price
                          const EProductPriceText(price: '35.0'),

                          ///Add To Cart Button
                          Container(
                            decoration: const BoxDecoration(
                              color: EColors.dark,
                              borderRadius: BorderRadius.only(
                                topLeft: Radius.circular(ESizes.cardRadiusMd),
                                bottomRight: Radius.circular(ESizes.productImageRadius),
                              )
                            ),

                            child: const SizedBox(
                              width: ESizes.iconLg * 1.2,
                                height: ESizes.iconLg * 1.2,
                                child: Center(child: Icon(Iconsax.add,color: EColors.white)),
                            ),
                          ),
                        ],
                      )
                    ],
                  ),
              )

            ],
          ),

      ),
    );
  }
}


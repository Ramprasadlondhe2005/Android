import 'package:e_store/app.dart';
import 'package:e_store/common/widgets_login_signup/success_screens/success_screens.dart';
import 'package:e_store/features/authentication/screens/login/login.dart';
import 'package:e_store/utils/constants/text_strings.dart';
import 'package:e_store/utils/helpers/helper_functions.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';

import '../../../../utils/constants/image_strings.dart';
import '../../../../utils/constants/sizes.dart';

class VerifyEmailScreen extends StatelessWidget {
  const VerifyEmailScreen({super.key});

  @override
  Widget build(BuildContext context) {
   return Scaffold(
     appBar: AppBar(
       automaticallyImplyLeading: false,
       actions: [
         IconButton(onPressed: () => Get.offAll(() => const LoginScreen()), icon: const Icon(CupertinoIcons.clear)),
       ],
     ),
     body: SingleChildScrollView(
       child: Padding(
           padding: EdgeInsets.all(ESizes.defaultSpace),
         child: Column(
           children: [

             ///Image
             Image(image: AssetImage(EImages.deliveredEmailIllustration),width: EHelperFunctions.screenWidth()*0.6),
             const SizedBox(height: ESizes.spaceBtwSections),


             ///Title & Subtitle
             Text(ETexts.confirmEmail,style: Theme.of(context).textTheme.headlineMedium,textAlign: TextAlign.center),
             const SizedBox(height: ESizes.spaceBtwItems),
             Text('support@codingint.com',style: Theme.of(context).textTheme.labelLarge,textAlign: TextAlign.center),
             const SizedBox(height: ESizes.spaceBtwItems),
             Text(ETexts.confirmEmailSubTitle,style: Theme.of(context).textTheme.labelMedium,textAlign: TextAlign.center),
             const SizedBox(height: ESizes.spaceBtwItems),


             ///Buttons
             SizedBox(
                 width: double.infinity,
                 child: ElevatedButton(
                     onPressed: () => Get.to(
                             () => SuccessScreen(
                                 image: EImages.staticSuccessIllustration,
                                 title: ETexts.yourAccountCreatedTitle,
                                 subTitle: ETexts.yourAccountCreatedSubTitle,
                                 onPressed: () => Get.to(() => LoginScreen()),
                             ),
                     ),
                     child: const Text(ETexts.tContinue))),
             const SizedBox(height: ESizes.spaceBtwItems),
             SizedBox(width: double.infinity,child: ElevatedButton(onPressed: (){}, child: const Text(ETexts.resendEmail))),

           ],
         ),
       ),
     ),
   );
  }
}

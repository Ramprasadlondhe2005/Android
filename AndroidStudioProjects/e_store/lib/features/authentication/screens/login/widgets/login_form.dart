import 'package:e_store/features/authentication/screens/password_configuration/forget_password.dart';
import 'package:e_store/features/authentication/screens/signup_widgets/signup.dart';
import 'package:e_store/navigation_menu.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:iconsax/iconsax.dart';

import '../../../../../utils/constants/sizes.dart';
import '../../../../../utils/constants/text_strings.dart';

class ELoginForm extends StatelessWidget {
  const ELoginForm({
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return Form(child: Padding(
      padding: const EdgeInsets.symmetric(vertical: ESizes.spaceBtwSections),
      child: Column(
        children: [
          ///Email
          TextFormField(
            decoration: const InputDecoration(prefixIcon: Icon(Iconsax.direct_right),labelText: ETexts.email),
          ),
          const SizedBox(height: ESizes.spaceBtwInputFields),

          ///Password
          TextFormField(
            decoration: const InputDecoration(prefixIcon: Icon(Iconsax.password_check),labelText: ETexts.password,suffixIcon: Icon(Iconsax.eye_slash)),
          ),
          const SizedBox(height: ESizes.spaceBtwInputFields / 2),

          ///Remeber Me and Forgot Password
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              ///Remember Me
              Row(
                children: [
                  Checkbox(value: true, onChanged: (value){}),
                  const Text(ETexts.rememberMe),
                ],
              ),

              ///Forget Password
              TextButton(onPressed: () => Get.to(() => const ForgetPassword()), child: const Text(ETexts.forgetPassword)),
            ],
          ),
          const SizedBox(height: ESizes.spaceBtwSections),

          ///Sign In Button
          SizedBox(width: double.infinity, child: ElevatedButton(onPressed: () =>Get.to(() => const NavigationMenu()), child: const Text(ETexts.signIn))),
          const SizedBox(height: ESizes.spaceBtwItems),
          ///Create Account Button
          SizedBox(width: double.infinity, child: ElevatedButton(onPressed: () => Get.to(() => const SignupScreen()), child: const Text(ETexts.createAccount))),
          //const SizedBox(height: ESizes.spaceBtwSections),
        ],
      ),
    ));
  }
}
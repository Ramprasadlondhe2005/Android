import 'package:e_store/common/widgets_login_signup/form_divider.dart';
import 'package:e_store/common/widgets_login_signup/social_buttons.dart';
import 'package:e_store/features/authentication/screens/signup_widgets/signup_form.dart';
import 'package:e_store/utils/constants/sizes.dart';
import 'package:e_store/utils/constants/text_strings.dart';
import 'package:e_store/utils/helpers/helper_functions.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';


class SignupScreen extends StatelessWidget {
  const SignupScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final dark = EHelperFunctions.isDarkMode(context);
    return Scaffold(
      appBar: AppBar(),
      body: SingleChildScrollView(
        child: Padding(
            padding: const  EdgeInsets.all(ESizes.defaultSpace),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                ///Title
                Text(ETexts.signupTitle,style: Theme.of(context).textTheme.headlineMedium),
                const SizedBox(height: ESizes.spaceBtwSections),


                ///Form
                const ESignUpForm(),
                const SizedBox(height: ESizes.spaceBtwSections),

                ///Divider
                EFormDivider(dark: dark, dividerText: ETexts.orSignInWith.capitalize!),
                const SizedBox(height: ESizes.spaceBtwSections),

                ///Social Buttons
                const ESocialButtons(),
              ],
            ),
        ),
      ),
    );
  }
}


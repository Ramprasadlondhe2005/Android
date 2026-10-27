import 'package:e_store/features/authentication/screens/signup_widgets/verify_email.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:iconsax/iconsax.dart';

import '../../../../utils/constants/colors.dart';
import '../../../../utils/constants/sizes.dart';
import '../../../../utils/constants/text_strings.dart';
import '../../../../utils/helpers/helper_functions.dart';

class ESignUpForm extends StatelessWidget {
  const ESignUpForm({
    super.key,

  });


  @override
  Widget build(BuildContext context) {
    final dark = EHelperFunctions.isDarkMode(context);
    return Form(child: Column(
      children: [
        Row(
          children: [
            Expanded(
                child: TextFormField(
                  expands: false,
                  decoration: const InputDecoration(
                    labelText: ETexts.firstName,
                    prefixIcon: Icon(Iconsax.user),
                  ),
                )
            ),
            const SizedBox(width: ESizes.spaceBtwInputFields),
            Expanded(
              child: TextFormField(
                expands: false,
                decoration: const InputDecoration(
                  labelText: ETexts.lastName,
                  prefixIcon: Icon(Iconsax.user),
                ),
              ),
            )],

        ),
        const SizedBox(height: ESizes.spaceBtwInputFields),

        ///Username
        TextFormField(
          expands: false,
          decoration: const InputDecoration(
            labelText: ETexts.username,
            prefixIcon: Icon(Iconsax.user_edit),
          ),
        ),


        ///Email
        TextFormField(
          decoration: const InputDecoration(
            labelText: ETexts.email,
            prefixIcon: Icon(Iconsax.direct),
          ),
        ),
        const SizedBox(height: ESizes.spaceBtwInputFields),


        ///Phone Number
        TextFormField(
          decoration: const InputDecoration(
            labelText: ETexts.phoneNo,
            prefixIcon: Icon(Iconsax.call),
          ),
        ),
        const SizedBox(height: ESizes.spaceBtwInputFields),

        ///Password
        TextFormField(
          obscureText: true,
          decoration: const InputDecoration(
            labelText: ETexts.password,
            prefixIcon: Icon(Iconsax.password_check),
            suffixIcon: Icon(Iconsax.eye_slash),
          ),
        ),
        const SizedBox(height: ESizes.spaceBtwInputFields),

        ///Terms & Conditions Checkbox
        Row(
          children: [
            SizedBox(width: 24,height: 24,child: Checkbox(value: true, onChanged: (value){})),
            const SizedBox(width: ESizes.spaceBtwItems),
            Text.rich(TextSpan(
              children: [
                TextSpan(text: '${ETexts.iAgreeTo}',style: Theme.of(context).textTheme.bodySmall),
                TextSpan(text: ETexts.privacyPolicy,style: Theme.of(context).textTheme.bodyMedium!.apply(
                  color: dark ? EColors.white: EColors.primary,
                  decoration: TextDecoration.underline,
                  decorationColor: dark ? EColors.white:EColors.primary,
                )),
                TextSpan(text: '${ETexts.and}',style: Theme.of(context).textTheme.bodySmall),
                TextSpan(text: ETexts.termsOfUse,style: Theme.of(context).textTheme.bodyMedium!.apply(
                  color: dark ? EColors.white: EColors.primary,
                  decoration: TextDecoration.underline,
                  decorationColor: dark ? EColors.white:EColors.primary,
                )),
              ],
            ))
          ],
        ),
        const SizedBox(height: ESizes.spaceBtwSections),

        ///Sign Up Button
        SizedBox(width: double.infinity,child: ElevatedButton(onPressed: () => Get.to(() => const VerifyEmailScreen()),child: const Text(ETexts.createAccount)),)
      ],
    ));
  }
}
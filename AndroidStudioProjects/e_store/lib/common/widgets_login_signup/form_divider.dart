import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../../utils/constants/colors.dart';
import '../../utils/constants/text_strings.dart';


class EFormDivider extends StatelessWidget {
  const EFormDivider({
    super.key,
    required this.dark, required String dividerText,
  });

  final bool dark;

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Flexible(child: Divider(color: dark ? EColors.darkGrey: EColors.grey, thickness: 0.5,indent: 60, endIndent: 5)),
        Text(ETexts.orSignInWith.capitalize!,style: Theme.of(context).textTheme.labelMedium),
        Flexible(child: Divider(color: dark ? EColors.darkGrey: EColors.grey, thickness: 0.5,indent: 5, endIndent: 60)),
      ],
    );
  }
}
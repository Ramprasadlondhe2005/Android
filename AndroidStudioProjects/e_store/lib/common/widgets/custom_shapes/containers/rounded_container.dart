import 'package:flutter/material.dart';

import 'package:flutter/material.dart';

import '../../../../utils/constants/colors.dart';
import '../../../../utils/constants/sizes.dart';

class ERoundedContainer extends StatelessWidget {
  const ERoundedContainer({
    super.key,
    this.child,
    this.width ,
    this.height ,
    this.margin,
    this.padding,
    this.showBorder = false,
    this.radius = ESizes.cardRadiusLg,
    this.backgroundColor = EColors.white,
    this.borderColor = EColors.borderPrimary,
  });

  final double? width;
  final double? height;
  final double  radius;
  final bool showBorder;
  final Color borderColor;
  final EdgeInsets? padding;
  final Widget? child;
  final Color? backgroundColor;
  final EdgeInsets? margin;

  @override
  Widget build(BuildContext context) {
    return Container(
      width: width,
      height: height,
      padding: padding,
      margin: margin,
      decoration: BoxDecoration(
        color: backgroundColor,
        borderRadius: BorderRadius.circular(radius),
        border: showBorder? Border.all(color: borderColor): null,
      ),
      child: child,
    );
  }
}

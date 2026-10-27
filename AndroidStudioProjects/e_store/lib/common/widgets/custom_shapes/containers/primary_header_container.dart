import 'package:flutter/material.dart';

import '../../../../utils/constants/colors.dart';
import '../curved_edges/curved_edge_widget.dart';
import 'circular_container.dart';

class EPrimaryHeaderContainer extends StatelessWidget {
  const EPrimaryHeaderContainer({
    super.key,required this.child,
  });

  final Widget child;
  @override
  Widget build(BuildContext context) {
    return ECurvedEdgeWidget(
      child: Container(
        color: EColors.primary,
        padding: const EdgeInsets.only(bottom: 0),

          ///--If[size.infinite : is not true in stack ] error occured -> Read README.md file at
          child: Stack(
            children: [
              Positioned(top: -150,right: -250,child: ECircularContainer(backgroundColor: EColors.textWhite.withOpacity(0.1))),
              Positioned(top: 100,right: -250,child: ECircularContainer(backgroundColor: EColors.textWhite.withOpacity(0.1))),
              child,
            ],
          ),
        ),
      );
  }
}


import 'package:e_store/utils/constants/image_strings.dart';
import 'package:e_store/utils/constants/text_strings.dart';
import 'package:e_store/utils/device/device_utility.dart';
import 'package:e_store/utils/helpers/helper_functions.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:smooth_page_indicator/smooth_page_indicator.dart';
import 'package:iconsax/iconsax.dart';
import '../../../../utils/constants/sizes.dart';
import '../../../../utils/constants/colors.dart';
import '../../controllers.onboarding/onboarding_controller.dart';

class OnBoardingScreen extends StatefulWidget {
  const OnBoardingScreen({super.key});

  @override
  State<OnBoardingScreen> createState() => _OnBoardingScreenState();
}

class _OnBoardingScreenState extends State<OnBoardingScreen> {
  final PageController _controller = PageController();

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final controller = Get.put(OnBoardingController());
    return Scaffold(
      body: Stack(
        children: [
          /// PageView with Onboarding Content
          PageView(
            controller: controller.pageController,
            onPageChanged: controller.updatePageIndicator,
            children: const [
              OnBoardingPage(
                  image: EImages.onBoardingImage1,
                  title: ETexts.onBoardingTitle1,
                  subTitle: ETexts.onBoardingSubTitle1),
              OnBoardingPage(
                  image: EImages.onBoardingImage2,
                  title: ETexts.onBoardingTitle2,
                  subTitle: ETexts.onBoardingSubTitle2),
              OnBoardingPage(
                  image: EImages.onBoardingImage3,
                  title: ETexts.onBoardingTitle3,
                  subTitle: ETexts.onBoardingSubTitle3),
            ],
          ),

          /// Skip Button
          const OnBoardingSkip(),

          /// Dot Navigation - SmoothPageIndicator
          OnBoardingDotNavigation(controller: _controller),
          
          ///Circular Buttons
          OnBoardingNextButton()
        ],
      ),
    );
  }
}

class OnBoardingNextButton extends StatelessWidget {
  const OnBoardingNextButton({
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    final dark = EHelperFunctions.isDarkMode(context);
    return Positioned(
        right: ESizes.defaultSpace,
        bottom: EDeviceUtils.getBottomNavigationBarHeight(),
        child:ElevatedButton(
          onPressed: (){},
          style: ElevatedButton.styleFrom(shape: const CircleBorder(), backgroundColor: dark ? EColors.primaryColor: Colors.black),
          child: const Icon(Iconsax.arrow_right_3),
        )
    );
  }
}

class OnBoardingDotNavigation extends StatelessWidget {
  const OnBoardingDotNavigation({
    super.key,
    required PageController controller,
  }) : _controller = controller;

  final PageController _controller;

  @override
  Widget build(BuildContext context) {
    final dark = EHelperFunctions.isDarkMode(context);
    return Positioned(
      bottom: EDeviceUtils.getBottomNavigationBarHeight() + 25,
      left: ESizes.defaultSpace,
      child: SmoothPageIndicator(
        controller: _controller,
        count: 3,
        effect: ExpandingDotsEffect(activeDotColor: dark ? EColors.light: EColors.dark, dotHeight: 6),
        ),
      );

  }
}

class OnBoardingSkip extends StatelessWidget {
  const OnBoardingSkip({super.key});

  @override
  Widget build(BuildContext context) {
    return Positioned(
      top: EDeviceUtils.getAppBarHeight(),
      right: ESizes.defaultSpace,
      child: TextButton(
        onPressed: () {
          // TODO: Navigate to home or login screen
        },
        child: const Text('Skip'),
      ),
    );
  }
}

class OnBoardingPage extends StatelessWidget {
  const OnBoardingPage({
    super.key,
    required this.image,
    required this.title,
    required this.subTitle,
  });

  final String image, title, subTitle;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(ESizes.defaultSpace),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Image(
            width: EHelperFunctions.screenWidth() * 0.8,
            height: EHelperFunctions.screenHeight() * 0.5,
            image: AssetImage(image),
          ),
          const SizedBox(height: ESizes.spaceBtwItems),
          Text(
            title,
            style: Theme.of(context).textTheme.headlineMedium,
            textAlign: TextAlign.center,
          ),
          const SizedBox(height: ESizes.spaceBtwItems),
          Text(
            subTitle,
            style: Theme.of(context).textTheme.bodyMedium,
            textAlign: TextAlign.center,
          ),
        ],
      ),
    );
  }
}

import 'package:e_store/features/authentication/screens/onboarding/onboarding.dart';
import 'package:e_store/utils/theme/theme.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';


class App extends StatelessWidget {
  const App({super.key});

  // This widgets is the root of your application.
  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
        //title: 'Flutter Demo',
        themeMode: ThemeMode.system,
        theme: EAppTheme.lightTheme,
        darkTheme:EAppTheme.darkTheme,
        home: const OnBoardingScreen(),
    );
  }
}

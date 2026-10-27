import 'package:e_store/features/shop/screens/home/widgets/home.dart';
import 'package:e_store/utils/constants/colors.dart';
import 'package:e_store/utils/helpers/helper_functions.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:iconsax/iconsax.dart';

class NavigationMenu extends StatelessWidget {
  const NavigationMenu({super.key});

  @override
  Widget build(BuildContext context) {
    final controller = Get.put(NavigationController());
    final darkMode = EHelperFunctions.isDarkMode(context);

    return Scaffold(
      bottomNavigationBar: Obx(
        () => NavigationBar(

        height: 80,
        elevation: 0,
        selectedIndex: controller.selectedInex.value,
        onDestinationSelected: (index) => controller.selectedInex.value = index,
        backgroundColor: darkMode ? EColors.black : Colors.white,
        indicatorColor: darkMode ? EColors.white.withOpacity(0.1) : EColors.black.withOpacity(0.1),
        destinations: const [
          NavigationDestination(icon: Icon(Iconsax.home), label: 'Home'),
          NavigationDestination(icon: Icon(Iconsax.shop), label: 'Store'),
          NavigationDestination(icon: Icon(Iconsax.heart), label: 'Wishlist'),
          NavigationDestination(icon: Icon(Iconsax.user), label: 'Profile'),
        ],
      ),
      ),
      body: Obx(() => controller.screens[controller.selectedInex.value]),

    );
  }
}

class NavigationController extends GetxController {
 final Rx<int> selectedInex = 0.obs;

 final screens= [const HomeScreen(),Container(color: Colors.purple),Container(color: Colors.orange),Container(color: Colors.blue)];
}

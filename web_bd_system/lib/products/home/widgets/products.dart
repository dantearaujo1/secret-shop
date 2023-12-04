import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:liquid_pull_to_refresh/liquid_pull_to_refresh.dart';
import 'package:web_bd_system/products/home/api/products_service.dart';
import 'package:web_bd_system/products/home/bloc/products_bloc.dart';
import 'package:web_bd_system/products/home/bloc/products_event.dart';
import 'package:web_bd_system/products/home/bloc/produts_state.dart';
import 'package:web_bd_system/products/home/widgets/products_card.dart';
import 'package:web_bd_system/utils/app_colors.dart';
import 'package:web_bd_system/widgets/error_page.dart';
import 'package:web_bd_system/widgets/loading_page.dart';

class Products extends StatelessWidget {
  const Products({super.key});

  ProductsBloc _createBloc() {
    return ProductsBloc(ProductsServiceImpl());
  }

  @override
  Widget build(BuildContext context) {
    return BlocProvider(
      create: (context) => _createBloc()..add(ProductsRequestEvent()),
      child: BlocListener<ProductsBloc, ProductsState>(
        listener: (context, state) {
          switch (state.runtimeType) {
            case ProductsDeletionSuccess:
              context.read<ProductsBloc>().add(ProductsRequestEvent());
          }
        },
        child: BlocBuilder<ProductsBloc, ProductsState>(
          builder: (context, state) {
            switch (state.runtimeType) {
              case ProductsLoadingState:
                return const LoadingPage();
              case ProductsErrorState:
                return Builder(builder: (context) {
                  return ErrorPage(
                    onPressed: () => context
                        .read<ProductsBloc>()
                        .add(ProductsRequestEvent()),
                  );
                });
              case ProductsSuccessState:
                final models = (state as ProductsSuccessState).products;

                return LiquidPullToRefresh(
                  color: AppColors.primaryColor,
                  backgroundColor: AppColors.primaryColor,
                  onRefresh: () async {
                    context.read<ProductsBloc>().add(ProductsRequestEvent());
                  },
                  child: ListView.builder(
                    itemCount: models.length,
                    itemBuilder: (BuildContext context, int index) {
                      final model = models[index];

                      return Padding(
                        padding: EdgeInsets.only(top: index == 0 ? 18 : 0),
                        child: ProductsCard(
                          id: model.id,
                          title: model.name,
                          description: model.description,
                        ),
                      );
                    },
                  ),
                );
              default:
                return Container();
            }
          },
        ),
      ),
    );
  }
}

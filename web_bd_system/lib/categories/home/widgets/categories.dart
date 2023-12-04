import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:liquid_pull_to_refresh/liquid_pull_to_refresh.dart';
import 'package:web_bd_system/categories/home/api/categories_service.dart';
import 'package:web_bd_system/categories/home/bloc/categories_bloc.dart';
import 'package:web_bd_system/categories/home/bloc/categories_event.dart';
import 'package:web_bd_system/categories/home/bloc/categories_state.dart';
import 'package:web_bd_system/categories/home/widgets/categories_card.dart';
import 'package:web_bd_system/utils/app_colors.dart';
import 'package:web_bd_system/widgets/error_page.dart';
import 'package:web_bd_system/widgets/loading_page.dart';

class Categories extends StatelessWidget {
  const Categories({super.key});

  CategoriesBloc _createBloc() {
    return CategoriesBloc(CategoriesServiceImpl());
  }

  @override
  Widget build(BuildContext context) {
    return BlocProvider(
      create: (context) => _createBloc()..add(CategoriesRequestEvent()),
      child: BlocListener<CategoriesBloc, CategoriesState>(
        listener: (context, state) {
          switch (state.runtimeType) {
            case CategoriesDeletionSuccess:
              context.read<CategoriesBloc>().add(CategoriesRequestEvent());
          }
        },
        child: BlocBuilder<CategoriesBloc, CategoriesState>(
          builder: (context, state) {
            switch (state.runtimeType) {
              case CategoriesLoadingState:
                return const LoadingPage();
              case CategoriesErrorState:
                return Builder(builder: (context) {
                  return ErrorPage(
                    onPressed: () => context
                        .read<CategoriesBloc>()
                        .add(CategoriesRequestEvent()),
                  );
                });
              case CategoriesSuccessState:
                final models = (state as CategoriesSuccessState).categories;

                return LiquidPullToRefresh(
                  color: AppColors.primaryColor,
                  backgroundColor: AppColors.primaryColor,
                  onRefresh: () async {
                    context
                        .read<CategoriesBloc>()
                        .add(CategoriesRequestEvent());
                  },
                  child: ListView.builder(
                    itemCount: models.length,
                    itemBuilder: (BuildContext context, int index) {
                      final model = models[index];

                      final description = model.description.isNotEmpty
                          ? model.description
                          : 'Sem descrição';

                      return Padding(
                        padding: EdgeInsets.only(top: index == 0 ? 16.0 : 0),
                        child: CategoriesCard(
                          id: model.id,
                          title: model.name,
                          description: description,
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

import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:liquid_pull_to_refresh/liquid_pull_to_refresh.dart';
import 'package:web_bd_system/sellers/home/api/sellers_service.dart';
import 'package:web_bd_system/sellers/home/bloc/sellers_bloc.dart';
import 'package:web_bd_system/sellers/home/bloc/sellers_event.dart';
import 'package:web_bd_system/sellers/home/bloc/sellers_state.dart';
import 'package:web_bd_system/sellers/home/widgets/sellers_card.dart';
import 'package:web_bd_system/utils/app_colors.dart';
import 'package:web_bd_system/widgets/error_page.dart';
import 'package:web_bd_system/widgets/loading_page.dart';

class Sellers extends StatelessWidget {
  const Sellers({super.key});

  @override
  Widget build(BuildContext context) {
    return BlocProvider(
      create: (context) =>
          SellersBloc(SellersServiceImpl())..add(SellersRequestEvent()),
      child: BlocListener<SellersBloc, SellersState>(
        listener: (context, state) {
          switch (state.runtimeType) {
            case SellersDeletionSuccess:
              context.read<SellersBloc>().add(SellersRequestEvent());
          }
        },
        child: BlocBuilder<SellersBloc, SellersState>(
          builder: (context, state) {
            switch (state.runtimeType) {
              case SellersLoadingState:
                return const LoadingPage();
              case SellersErrorState:
                return Builder(builder: (context) {
                  return ErrorPage(
                    onPressed: () =>
                        context.read<SellersBloc>().add(SellersRequestEvent()),
                  );
                });
              case SellersSuccessState:
                final models = (state as SellersSuccessState).sellers;

                return LiquidPullToRefresh(
                  color: AppColors.primaryColor,
                  backgroundColor: AppColors.primaryColor,
                  onRefresh: () async {
                    context.read<SellersBloc>().add(SellersRequestEvent());
                  },
                  child: ListView.builder(
                    itemCount: models.length,
                    itemBuilder: (BuildContext context, int index) {
                      final model = models[index];

                      return Padding(
                        padding: EdgeInsets.only(top: index == 0 ? 16 : 0),
                        child: SellersCard(
                          id: model.id,
                          title: model.name,
                          description: model.id,
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

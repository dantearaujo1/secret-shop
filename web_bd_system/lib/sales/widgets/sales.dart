import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:liquid_pull_to_refresh/liquid_pull_to_refresh.dart';
import 'package:web_bd_system/sales/api/sales_service.dart';
import 'package:web_bd_system/sales/bloc/sales_bloc.dart';
import 'package:web_bd_system/sales/bloc/sales_event.dart';
import 'package:web_bd_system/sales/bloc/sales_state.dart';
import 'package:web_bd_system/sales/widgets/sales_card.dart';
import 'package:web_bd_system/widgets/error_page.dart';
import 'package:web_bd_system/widgets/loading_page.dart';

class Sales extends StatelessWidget {
  const Sales({super.key});

  SalesBloc _createBloc() {
    return SalesBloc(SalesServiceImpl());
  }

  @override
  Widget build(BuildContext context) {
    return BlocProvider(
      create: (context) => _createBloc()..add(SalesRequestEvent()),
      child: BlocListener<SalesBloc, SalesState>(
        listener: (context, state) {
          switch (state.runtimeType) {
            case SalesDeletionSuccess:
              context.read<SalesBloc>().add(SalesRequestEvent());
          }
        },
        child: BlocBuilder<SalesBloc, SalesState>(
          builder: (context, state) {
            switch (state.runtimeType) {
              case SalesLoadingState:
                return const LoadingPage();
              case SalesErrorState:
                return Builder(builder: (context) {
                  return ErrorPage(
                    onPressed: () => context
                        .read<SalesBloc>()
                        .add(SalesRequestEvent()),
                  );
                });
              case SalesSuccessState:
                final models = (state as SalesSuccessState).sales;

                return LiquidPullToRefresh(
                  color: Colors.black12,
                  backgroundColor: Colors.black12,
                  onRefresh: () async {
                    context
                        .read<SalesBloc>()
                        .add(SalesRequestEvent());
                  },
                  child: ListView.builder(
                    itemCount: models.length,
                    itemBuilder: (BuildContext context, int index) {
                      final model = models[index];

                      final description = model.description.isNotEmpty
                          ? model.description
                          : 'Sem descrição';

                      return SalesCard(
                        id: model.id,
                        title: model.name,
                        description: description,
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
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:liquid_pull_to_refresh/liquid_pull_to_refresh.dart';
import 'package:web_bd_system/clients/home/api/client_service.dart';
import 'package:web_bd_system/clients/home/bloc/client_bloc.dart';
import 'package:web_bd_system/clients/home/bloc/client_event.dart';
import 'package:web_bd_system/clients/home/bloc/client_state.dart';
import 'package:web_bd_system/clients/home/widgets/client_card.dart';
import 'package:web_bd_system/utils/app_colors.dart';
import 'package:web_bd_system/widgets/error_page.dart';
import 'package:web_bd_system/widgets/loading_page.dart';

class Clients extends StatelessWidget {
  const Clients({super.key});

  ClientBloc _createBloc() {
    return ClientBloc(ClientServiceImpl());
  }

  @override
  Widget build(BuildContext context) {
    return BlocProvider(
      create: (context) => _createBloc()..add(ClientRequestEvent()),
      child: BlocListener<ClientBloc, ClientState>(
        listener: (context, state) {
          switch (state.runtimeType) {
            case ClientDeletionSuccess:
              context.read<ClientBloc>().add(ClientRequestEvent());
          }
        },
        child: BlocBuilder<ClientBloc, ClientState>(
          builder: (context, state) {
            switch (state.runtimeType) {
              case ClientLoadingState:
                return const LoadingPage();
              case ClientErrorState:
                return Builder(builder: (context) {
                  return ErrorPage(
                    onPressed: () =>
                        context.read<ClientBloc>().add(ClientRequestEvent()),
                  );
                });
              case ClientSuccessState:
                final models = (state as ClientSuccessState).clients;

                return LiquidPullToRefresh(
                  color: AppColors.primaryColor,
                  backgroundColor: AppColors.primaryColor,
                  onRefresh: () async {
                    context.read<ClientBloc>().add(ClientRequestEvent());
                  },
                  child: ListView.builder(
                    itemCount: models.length,
                    itemBuilder: (BuildContext context, int index) {
                      final model = models[index];

                      final contact = model.contacts.isNotEmpty
                          ? '(${model.contacts.first.ddd}) ${model.contacts.first.phoneNumber}'
                          : 'Sem contato';

                      return Padding(
                        padding: EdgeInsets.only(top: index == 0 ? 16 : 0),
                        child: ClientCard(
                          id: model.id,
                          title: model.name,
                          description: contact,
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

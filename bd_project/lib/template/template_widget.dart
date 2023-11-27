import 'package:bd_project/pages_defaults/error_page.dart';
import 'package:bd_project/pages_defaults/loadind_page.dart';
import 'package:bd_project/template/api/template_service.dart';
import 'package:bd_project/template/bloc/template_bloc.dart';
import 'package:bd_project/template/bloc/template_event.dart';
import 'package:bd_project/template/bloc/template_state.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

class TemplateWidget extends StatelessWidget {
  const TemplateWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return BlocProvider(
      create: (_) =>
          TemplateBloc(TemplateServiceImpl())..add(TemplateRequestEvent()),
      child: BlocBuilder<TemplateBloc, TemplateState>(
        builder: (_, state) {
          switch (state.runtimeType) {
            case TemplateLoadingState:
              return const LoadingPage();
            case TemplateErrorState:
              return ErrorPage(
                onPressed: () =>
                    context.read<TemplateBloc>().add(TemplateRequestEvent()),
              );
            case TemplateSuccessState:
              final quote = (state as TemplateSuccessState).quote;

              return Center(
                child: Text(
                  quote,
                  style: const TextStyle(fontSize: 24),
                ),
              );
            default:
              return Container();
          }
        },
      ),
    );
  }
}

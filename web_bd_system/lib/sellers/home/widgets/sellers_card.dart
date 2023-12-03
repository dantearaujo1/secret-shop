import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:web_bd_system/categories/update/api/categories_update_service.dart';
import 'package:web_bd_system/categories/update/bloc/categories_update_bloc.dart';
import 'package:web_bd_system/categories/update/widgets/categories_update.dart';
import 'package:web_bd_system/sellers/home/bloc/sellers_bloc.dart';
import 'package:web_bd_system/sellers/home/bloc/sellers_event.dart';

class SellersCard extends StatelessWidget {
  const SellersCard({
    super.key,
    required this.id,
    required this.title,
    required this.description,
  });

  final String id;
  final String title;
  final String description;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: ClipRRect(
        borderRadius: BorderRadius.circular(8),
        child: Container(
          color: Colors.black12,
          child: Row(
            children: [
              const Padding(
                padding: EdgeInsets.symmetric(horizontal: 16.0),
                child: Icon(
                  Icons.person,
                  size: 36,
                ),
              ),
              Padding(
                padding: const EdgeInsets.symmetric(vertical: 8.0),
                child: SizedBox(
                  width: MediaQuery.of(context).size.width * 0.5,
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        title,
                        softWrap: true,
                        style: const TextStyle(fontSize: 20),
                      ),
                      Text(
                        description,
                        softWrap: true,
                        style: const TextStyle(fontSize: 16),
                      ),
                    ],
                  ),
                ),
              ),
              Expanded(child: Container()),
              IconButton(
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (_) => BlocProvider(
                        create: (_) => CategoriesUpdateBloc(
                          CategoriesUpdateServiceImpl(),
                        ),
                        child: CategoriesUpdate(categoryID: id),
                      ),
                    ),
                  );
                },
                icon: const Icon(
                  Icons.edit,
                  size: 24,
                  color: Colors.black,
                ),
              ),
              IconButton(
                onPressed: () {
                  context.read<SellersBloc>().add(
                        SellersRequestDeleteEvent(id),
                      );
                },
                icon: const Icon(
                  Icons.delete,
                  size: 24,
                  color: Colors.black,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

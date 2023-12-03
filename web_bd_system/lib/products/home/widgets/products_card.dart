import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:web_bd_system/products/home/bloc/products_bloc.dart';
import 'package:web_bd_system/products/home/bloc/products_event.dart';

class ProductsCard extends StatelessWidget {
  const ProductsCard({
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
                  Icons.shopping_bag,
                  size: 36,
                ),
              ),
              Padding(
                padding: const EdgeInsets.symmetric(vertical: 8.0),
                child: SizedBox(
                  width: MediaQuery.of(context).size.width * 0.6,
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
                  context
                      .read<ProductsBloc>()
                      .add(ProductsRequestDeleteEvent(id));
                },
                icon: const Padding(
                  padding: EdgeInsets.symmetric(horizontal: 8.0),
                  child: Icon(
                    Icons.delete,
                    size: 24,
                    color: Colors.black,
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

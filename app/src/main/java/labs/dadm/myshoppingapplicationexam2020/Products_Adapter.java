package labs.dadm.myshoppingapplicationexam2020;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Products_Adapter extends RecyclerView.Adapter<Products_Adapter.ImageViewHolder> {


   private ArrayList<Items> products;

   Products_Adapter(ArrayList<Items> products, ProductList products1) {
       this.products = products;
   }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_items, parent, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.product_text.setText(products.get(position).getText());
        holder.product_picture.setImageResource(products.get(position).getProductId());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder
    {
        ImageView product_picture;
        TextView product_text;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            product_picture = itemView.findViewById(R.id.iv_pic1);
            product_text = itemView.findViewById(R.id.tvpic1_text);
        }
    }
}



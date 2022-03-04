import http from "@/services/http-common";

class ProductDataService {
  getAll() {
    return http.get("/products");
  }

  get(id: string) {
    return http.get(`/products/${id}`);
  }

  create(data: any) {
    return http.post("/products", data);
  }

  update(id: any, data: any) {
    return http.put(`/products/${id}`, data);
  }

  delete(id: any) {
    return http.delete(`/products/${id}`);
  }

  deleteAll() {
    return http.delete(`/products`);
  }

  findByTitle(name: string) {
    return http.get(`/products?name=${name}`);
  }
}

export default new ProductDataService();
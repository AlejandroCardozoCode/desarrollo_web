import { crearDoc } from "../../store/urls";
import { sendRequest } from "../api/api-rest";
import { crear_doc } from "../../types/Doctor/crearDoc";
export const crear_doctor = {
  async crear(doc: crear_doc): Promise<void> {
    const url: string = process.env.VUE_APP_BASE_URL.concat(crearDoc);
    const response = await sendRequest(url, "post", JSON.stringify(doc));
  },
};

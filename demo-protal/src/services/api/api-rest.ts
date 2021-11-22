export async function sendRequest(
  url: string,
  verb: string,
  body?: any
): Promise<Response> {
  const config = {
    method: verb,
    headers: {
      "Content-Type": "aplication/json",
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Headers": "*",
      "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE",
    },

    body: body,
  };

  const response = await fetch(url, config);

  if (!response.ok) {
    const error = await response.json();
    throw new Error(error.error);
    console.log("El error es: " + error.error);
  }

  return response;
}

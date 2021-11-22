export async function sendRequest(
  url: string,
  verb: string,
  body?: any
): Promise<Response> {
  const config = {
    method: verb,
    header: {
      "Content-Type": "aplication/json",
    },

    body: body,
  };

  const response = await fetch(url, config);

  if (!response.ok) {
    const error = await response.json();
    throw new Error(error.error);
  }

  return response;
}
